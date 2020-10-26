package com.example.tymotsko

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.tymotsko.timer.ActiveTimer
import com.example.tymotsko.timer.DestroyTimer
import com.example.tymotsko.timer.MainTimer
import kotlinx.android.synthetic.main.fragment_1.*
import timber.log.Timber
import java.io.ByteArrayOutputStream
import java.util.logging.Level.INFO
import kotlin.properties.Delegates

class Fragment1 : Fragment() {
    private lateinit var timerActive: MainTimer
    private lateinit var timerToDestroy: MainTimer
    private var counter = 0
    private var created = false
    private lateinit var btn: Button
    private lateinit var visibil: String

    lateinit var mView: View
    private lateinit var imBtn: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)


        mView = inflater.inflate(R.layout.fragment_1, container, false)

        Timber.i("Program started")
        Timber.i("OnCreate Called")
               if(savedInstanceState != null){
            Timber.i("NOT NULL")
            val num: Int? = savedInstanceState.getString(visibil)?.toInt()
            imBtn = mView.findViewById<View>(R.id.imageView3) as ImageView
            imageView3.visibility = View.VISIBLE
        }
        timerActive = ActiveTimer(this.lifecycle)
        timerToDestroy = DestroyTimer(this.lifecycle)
        btn = mView.findViewById<View>(R.id.button3) as Button
        btn.setOnClickListener {
            imBtn = mView.findViewById<View>(R.id.imageView3) as ImageView
            imBtn.visibility = View.VISIBLE
        }
        return mView
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main, menu)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        visibil = "_"
        outState.putString(visibil, "1")


        Timber.i("onSaveInstanceState Called")
    }

    private fun imageToBitmap(image: ImageView): ByteArray {
        val bitmap = (image.drawable as BitmapDrawable).bitmap
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 90, stream)

        return stream.toByteArray()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Timber.i("___ITEM SELECTION IN MENU___")
        when (item.itemId) {
            R.id.share -> shareSuccess()

        }
        return super.onOptionsItemSelected(item)
    }


    private fun getShareIntent() {
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

    override fun onStart() {
        super.onStart()
        Timber.i("OnStart Called")
    }

    override fun onResume() {
        super.onResume()
        Timber.i("OnResume Called")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("OnPause Called")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("OnStop Called")
    }

    override fun onDestroy() {

        Timber.i("OnDestroy Called")
        var percent =
            timerActive.secondsCount.toDouble() / timerToDestroy.secondsCount.toDouble() * 100
        Timber.i("Time from onStart to onDestroy is : ${timerActive.secondsCount}/${timerToDestroy.secondsCount} seconds : $percent %")
        super.onDestroy()
    }

}