package org.employment;


public class Pegawai {
    private String nama;
    private String nikId;
    private String tempatLahir;
    private String jenisKelamin;
    private String alamat;
    private String status;

    // Constructor
    public Pegawai(String nama, String nikId, String tempatLahir,
                   String jenisKelamin,
                   String alamat, String status) {
        this.nama = nama;
        this.nikId = nikId;
        this.tempatLahir = tempatLahir;
        this.jenisKelamin = jenisKelamin;
        this.alamat = alamat;
        this.status = status;
    }

    // Getter methods
    // ...
}