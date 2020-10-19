package com.example.tymotsko

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import com.example.tymotsko.R
import java.text.SimpleDateFormat
import java.util.*

class Fragment1 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_1, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getShareIntent()  {
        val myIntent = Intent(Intent.ACTION_SEND)
        myIntent.type = "type/plain"
        val shareBody = "You are body"
        val shareSub = "You subject here"
        myIntent.putExtra(Intent.EXTRA_SUBJECT, shareBody)
        myIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub)
        startActivity(Intent.createChooser(myIntent, "Share Your App"))
    }

    private fun shareSuccess() {
        getShareIntent()
    }

}