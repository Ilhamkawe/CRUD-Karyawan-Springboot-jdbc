PGDMP                         {            Karyawan    14.5    14.5     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16398    Karyawan    DATABASE     n   CREATE DATABASE "Karyawan" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1252';
    DROP DATABASE "Karyawan";
                postgres    false            �            1259    24590 	   informasi    TABLE       CREATE TABLE public.informasi (
    kode_karyawan character varying(255),
    nama_karyawan character varying(255),
    tgl_masuk date,
    no_hp character varying(255),
    limit_reimbursement bigint,
    created_at timestamp with time zone,
    updated_at timestamp with time zone
);
    DROP TABLE public.informasi;
       public         heap    postgres    false            �           0    0    TABLE informasi    COMMENT     ;   COMMENT ON TABLE public.informasi IS 'informasi karyawan';
          public          postgres    false    209            �          0    24590 	   informasi 
   TABLE DATA           �   COPY public.informasi (kode_karyawan, nama_karyawan, tgl_masuk, no_hp, limit_reimbursement, created_at, updated_at) FROM stdin;
    public          postgres    false    209   �       �   �   x�u��
1D��W����f�MR�I�����+N0
w��
v�̼����NZ���pk��ԢO��I�
��;��<`� ��!4�7�EN̉��OmrC�����uy��=:��!Ƹb{N^��>�$�(��1��S+�     