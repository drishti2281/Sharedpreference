package com.example.sharedpreference

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sharedpreference.databinding.FragmentSharedPerfsBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SharedPrefsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SharedPrefsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var binding : FragmentSharedPerfsBinding ? = null
    lateinit var mainActivity: MainActivity
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: Editor
    lateinit var adapter: Recyclerview
    var count: Int = 0
    var selectedColor: Int = 0

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
        binding = FragmentSharedPerfsBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences = mainActivity.getSharedPreferences(mainActivity.getString(R.string.app_name), MODE_PRIVATE)
        editor = sharedPreferences.edit()
        adapter = Recyclerview(mainActivity)

        binding?.recyclerView?.layoutManager = LinearLayoutManager(mainActivity,LinearLayoutManager.VERTICAL, false)
        binding?.recyclerView?.adapter = adapter

        updateUI()

        binding?.btnRed?.setOnClickListener {
            selectedColor = 0
        }
        binding?.btnBlue?.setOnClickListener {
            selectedColor = 1
        }
        binding?.btnGreen?.setOnClickListener {
            selectedColor = 2
        }

        binding?.btnSave?.setOnClickListener {
            if (binding?.etcount?.text.toString().isNullOrEmpty()){
                binding?.etcount?.error = resources.getString(R.string.enter_number)
            }else{
                editor.putInt("Count",(binding?.etcount?.text?.toString()?:"0").toInt())
                editor.putInt("Color",selectedColor)
                editor.commit()
                editor.apply()
                Toast.makeText(requireContext(),resources.getString(R.string.Save),Toast.LENGTH_SHORT).show()
                updateUI()
            }
        }
        binding?.btnClear?.setOnClickListener {
            editor.clear()
            editor.apply()
            editor.commit()
            Toast.makeText(requireContext(),resources.getString(R.string.Clear),Toast.LENGTH_SHORT).show()
            updateUI()
        }
    }

    fun updateUI(){
        count = sharedPreferences.getInt("Count", 0)
        selectedColor = sharedPreferences.getInt("Color", 0)
        binding?.etcount?.setText(count.toString())
        adapter.updateCount(count)
        adapter.updateColor(selectedColor)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SharedPrefsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SharedPrefsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}