package com.example.sharedpreference

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sharedpreference.databinding.FragmentSharedPerfsBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SharedPerfsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SharedPerfsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var binding: FragmentSharedPerfsBinding? =null
    lateinit var mainActivity: MainActivity
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: Editor
    var count: Int = 0
    var color: String = ""
    lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = activity as MainActivity

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSharedPerfsBinding.inflate(layoutInflater)
        return (binding?.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = RecyclerView(mainActivity)
        binding?.recyclerView?.layoutManager = LinearLayoutManager(mainActivity)
      //  binding?.recyclerView?.adapter = RecyclerView
        sharedPreferences = mainActivity.getSharedPreferences(mainActivity.resources.getString(
            R.string.app_name), MODE_PRIVATE)
        editor =sharedPreferences. edit()

        count = sharedPreferences.getInt("number",0)

        val number = null
        binding?.etcount?.setText(number.toString())

        binding?.btnRed?.setOnClickListener {
            if (binding?.etcount?.text?.toString()?.trim().isNullOrEmpty())
                binding?.etcount?.error = mainActivity.resources.getString(R.string.enter_number)
        }
        binding?.btnGreen?.setOnClickListener {
            if (binding?.etcount?.text?.toString()?.trim().isNullOrEmpty())
                binding?.etcount?.error = mainActivity.resources.getString(R.string.enter_number)
        }
        binding?.btnBlue?.setOnClickListener {
            if (binding?.etcount?.text?.toString()?.trim().isNullOrEmpty())
                binding?.etcount?.error = mainActivity.resources.getString(R.string.enter_number)
        }
        binding?.btnSave?.setOnClickListener {
            if(binding?.etcount?.text?.toString()?.trim().isNullOrEmpty())
                binding?.etcount?.error = mainActivity.resources.getString(R.string.enter_number)

            editor.putInt("RollNo", (binding?.etcount?.text?.toString()?:"0").toInt())
            editor.commit()
            editor.apply()
        }
        binding?.btnClear?.setOnClickListener {
            editor.clear()
            editor.apply()
            editor.commit()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SharedPerfsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SharedPerfsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}