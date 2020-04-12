package id.ac.unhas.infocovid19.model

import com.google.gson.annotations.SerializedName

data class DataHarian(
    @SerializedName("data")
    val data: List<Harian?>?
){
    override fun toString(): String {
        var stringOutput = ""
        data?.forEach{
            stringOutput += it.toString()
        }
        return stringOutput
    }
}

data class Harian(
    @SerializedName("harike")
    val harike: Int?,

    @SerializedName("jumlahKasusBaruperHari")
    val jumlahKasusBaruperHari: Int?,

    @SerializedName("jumlahKasusKumulatif")
    val jumlahKasusKumulatif: Int?,

    @SerializedName("jumlahpasiendalamperawatan")
    val jumlahpasiendalamperawatan: Int?,

    @SerializedName("jumlahPasienSembuh")
    val jumlahPasienSembuh: Int?,

    @SerializedName("jumlahPasienMeninggal")
    val jumlahPasienMeninggal: Int?,

    val harian: CharSequence?

){


    override fun toString(): String {
        return "Kasus Baru: ${this.jumlahKasusBaruperHari}, jumlah kasus kumulatif: ${this.jumlahKasusKumulatif}, Dalam perawatan: ${this.jumlahpasiendalamperawatan}, pasien Sembuh: ${this.jumlahPasienSembuh}, pasien meninggal: ${this.jumlahPasienMeninggal}]"
    }
}