package id.ac.unhas.infocovid19.ui.harian

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.ac.unhas.infocovid19.R
import id.ac.unhas.infocovid19.model.Harian
import kotlinx.android.synthetic.main.recyclerview_item_harian.view.*

class HarianAdapter(private val daftarHarian: ArrayList<Harian>) :
    RecyclerView.Adapter<HarianAdapter.HarianHolder>() {
    class HarianHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(itemHarian: Harian) {
            with(itemView){
                harian.text = "Hari ke-" + itemHarian.harike.toString()
                data_harian.text = "${itemHarian.jumlahKasusBaruperHari} kasus positif baru, total ${itemHarian.jumlahKasusKumulatif} positif, total ${itemHarian.jumlahpasiendalamperawatan} pasien dalam perawatan, ${itemHarian.jumlahPasienSembuh} pasien sembuh, ${itemHarian.jumlahPasienMeninggal} pasien meninggal"
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HarianHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.recyclerview_item_harian,parent,false)
        return HarianHolder(view)
    }

    override fun getItemCount() = daftarHarian.size

    override fun onBindViewHolder(holder: HarianHolder, position: Int) {
        holder.bind(daftarHarian[position])
    }

}