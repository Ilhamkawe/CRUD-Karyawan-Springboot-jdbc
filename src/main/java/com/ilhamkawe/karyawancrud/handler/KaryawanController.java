package com.ilhamkawe.karyawancrud.handler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;

import com.ilhamkawe.karyawancrud.dto.CreateRequestDto;
import com.ilhamkawe.karyawancrud.dto.UpdateRequestDto;
import com.ilhamkawe.karyawancrud.helper.Helper;
import com.ilhamkawe.karyawancrud.service.impl.KaryawanServiceImpl;

import jakarta.annotation.Nullable;

@Controller
@RequiredArgsConstructor
public class KaryawanController {
    private final KaryawanServiceImpl karyawanService;
    private final Helper helper;
    // public KaryawanController(KaryawanServiceImpl karyawanService) {
    // this.karyawanService = karyawanService;
    // }

    @GetMapping("/")
    public String home(@RequestParam(name = "name", required = false, defaultValue = "") String name,
            @RequestParam(name = "tglMsk", required = false, defaultValue = "") String tglMsk,
            @RequestParam(name = "noHp", required = false, defaultValue = "") String noHp, Model model) {

        model.addAttribute("data", karyawanService.Search(name, tglMsk, noHp));
        return "index";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("create") CreateRequestDto create, RedirectAttributes redirAttrs,
            Model model) {

        // ! cek apakah nama sudah ada
        if (!karyawanService.FindByName(create.getNama()).isEmpty()) {
            redirAttrs.addFlashAttribute("gagal", "Sudah ada nama terdaftar");
            return "redirect:/";
        }

        // ! cek seilsih tanggal
        if (!helper.jejangTanggal(create.getTglMsk())) {
            redirAttrs.addFlashAttribute("gagal",
                    "Tanggal masuk kerja tidak boleh 2 bulan lebih lama atau 3 bulan lebih besar dari tanggal saat ini.");
            return "redirect:/";
        }

        int result = karyawanService.Create(create);

        if (result == 0) {
            redirAttrs.addFlashAttribute("gagal", "Gagal Input Data");
        } else {
            redirAttrs.addFlashAttribute("berhasil", "Berhasil Input Data");
        }

        return "redirect:/";
    }

    @DeleteMapping("/{kode}/destroy")
    public String destroy(@PathVariable String kode, RedirectAttributes redirAttrs) {

        if (karyawanService.Destroy(kode) > 0) {
            redirAttrs.addFlashAttribute("berhasil", "Berhasil Delete Data");
        } else {
            redirAttrs.addFlashAttribute("gagal", "Gagal Delete Data");
        }

        return "redirect:/";
    }

    @GetMapping("/{kode}/edit")
    public String edit(@PathVariable String kode, Model model) {
        model.addAttribute("data", karyawanService.FindByKode(kode));
        return "update";
    }

    @PutMapping("/{kode}/update")
    public String edit(@PathVariable String kode, UpdateRequestDto update, RedirectAttributes redirAttrs, Model model) {
        // ! cek apakah nama sudah ada
        if (!karyawanService.FindByNameExceptMe(update.getNama(), update.getKodeKaryawan()).isEmpty()) {
            redirAttrs.addFlashAttribute("gagal", "Sudah ada nama terdaftar");
            return "redirect:/";
        }

        // ! cek seilsih tanggal
        if (!helper.jejangTanggal(update.getTglMsk())) {
            redirAttrs.addFlashAttribute("gagal",
                    "Tanggal masuk kerja tidak boleh 2 bulan lebih lama atau 3 bulan lebih besar dari tanggal saat ini.");
            return "redirect:/";
        }

        int result = karyawanService.Update(update);

        if (result == 0) {
            redirAttrs.addFlashAttribute("gagal", "Gagal Update Data");
        } else {
            redirAttrs.addFlashAttribute("berhasil", "Berhasil Update Data");
        }

        return "redirect:/";
    }

}
