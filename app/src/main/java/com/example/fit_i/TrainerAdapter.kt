package com.example.fit_i

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.fit_i.databinding.ItemTrainerBinding

class TrainerAdapter(private val dataList: ArrayList<TrainerData>): RecyclerView.Adapter<TrainerAdapter.ViewHolder>() {
    inner class ViewHolder(private val viewBinding: ItemTrainerBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun bind(position: Int) {
            viewBinding.tvName.text = dataList[position].name
            //viewBinding.imgFricard.setImageResource(dataList[position].front)
            itemView.setOnClickListener {
                Log.d("Click", "success")
//                Toast.makeText(this,  "${dataList[position].name}의 명함입니다.}", Toast.LENGTH_SHORT).show()
//                Toast.makeText(this@friendRVAdapter,
//                    "${dataList[position].name}의 명함입니다.}",
//                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    interface OnItemClickListener : AdapterView.OnItemClickListener {
        //fun onClick(v: View, position: Int)
        fun onItemClick(v:View,data:TrainerData,position: Int)
        //override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        //  TODO("Not yet implemented")
        //}
    }

//    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
//        this.itemClickListener = onItemClickListener
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding =
            ItemTrainerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
        /*
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView?.context, CardDetailActivity::class.java)
            intent.putExtra("front", dataList[position].front)
            intent.putExtra("back", dataList[position].back)
            intent.putExtra("name", dataList[position].name)
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }*/
    }

    override fun getItemCount(): Int = dataList.size

//    fun setItemClickListener(onItemClickListener: Any) {
//        this.itemClickListener = onItemClickListener as AdapterView.OnItemClickListener
//    }
//    private lateinit var itemClickListener : AdapterView.OnItemClickListener

}
/*
class myAdapter(val listener : OnItemClickListener) :  RecyclerView.Adapter<friendRVAdapter.ViewHolder>() {
    interface OnItemClickListener {
        fun onItemClick(v:View, position: Int)
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.front.setOnClickListener {
            listener.onItemClick(holder.itemView, position)
        }
    }
}*/

/*
public class friendRVAdapter extends RecyclerView.Adapter<PhRecyclerViewHolder> {
    @Override
    public PhRecyclerViewHolder onCreateViewHolder(ViewGroup a_viewGroup, int a_viewType) {
        View view = LayoutInflater.from(a_viewGroup.getContext()).inflate(R.layout.content_recycler_item, a_viewGroup, false);
        return new PhRecyclerViewHolder(view);
    }
    @Override
    public void onBindViewHolder(PhRecyclerViewHolder a_viewHolder, int a_position) {
        final PhRecyclerItem item = mItemList.get(a_position);
        a_viewHolder.ivIcon.setImageResource(item.getImageResId());
        a_viewHolder.tvName.setText(item.getName());
    }
*/