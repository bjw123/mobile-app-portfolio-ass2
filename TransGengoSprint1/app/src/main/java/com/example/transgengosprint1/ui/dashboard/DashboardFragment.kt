package com.example.transgengosprint1.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ajithvgiri.canvaslibrary.CanvasView
import com.example.transgengosprint1.R


class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
                ViewModelProvider(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        //https://github.com/ajithvgiri/canvas library
        val parentView: RelativeLayout = root.findViewById(R.id.parentView)
        val canvasView = CanvasView(context)
        parentView.addView(canvasView)


        val clearBtn: Button = root.findViewById(R.id.clear_btn)
        clearBtn.setOnClickListener {
            canvasView.clearCanvas()
        }

        return root
    }
}