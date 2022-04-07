package com.axinpz.proyectosegundoparcial

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ApplicationsAdapter(context: Context, feedEntries: ArrayList<FeedEntry>): RecyclerView.Adapter<ApplicationsAdapter.ViewHolder>() {
    private var localContext: Context? = null
    private var localFeedEntries: ArrayList<FeedEntry>? = null

    init {
        localContext = context
        localFeedEntries = feedEntries
    }

    //Inflar el layout
    //Infla una vista dentro de este mainActivity
    //Se busca inflar n cantdiad de vistas necesarias
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int ): ApplicationsAdapter.ViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(localContext)
        val view: View = layoutInflater.inflate(R.layout.cards, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ApplicationsAdapter.ViewHolder, position: Int) {
        //Creeme 100% que este objeto no es nulo -> !!, ignora que te dije que es nuleable
        val currentFeedEntry: FeedEntry = localFeedEntries!![position]
        holder.textTitle.text = currentFeedEntry.title
        holder.textPubDate.text = currentFeedEntry.pubDate
        holder.textAuthor.text = currentFeedEntry.author
        holder.textDesc.text = currentFeedEntry.description.take(250).plus(" ...")

    }

    override fun getItemCount(): Int {
        //Si existe hazlo, si no, devuelve 0 como tamaño
        return localFeedEntries?.size ?:0
    }

    class ViewHolder(v: View): RecyclerView.ViewHolder(v) {

        val textTitle: TextView = v.findViewById(R.id.textViewTitle)
        val textPubDate: TextView = v.findViewById(R.id.textViewPubDate)
        val textAuthor: TextView = v.findViewById(R.id.textViewAuthor)
        val textDesc: TextView = v.findViewById(R.id.textViewDesc)
    }
}