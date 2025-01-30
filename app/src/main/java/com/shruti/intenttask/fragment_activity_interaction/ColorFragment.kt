package com.shruti.intenttask.fragment_activity_interaction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.shruti.intenttask.R
import com.shruti.intenttask.databinding.FragmentColorBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
/**
 * A simple [Fragment] subclass.
 * Use the [ColorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ColorFragment : Fragment(), ColorInterface {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding : FragmentColorBinding
    lateinit var colorActivity: ColorActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        colorActivity = activity as ColorActivity
        colorActivity.colorInterface = this
        colorActivity
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentColorBinding.inflate(layoutInflater)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnFirst.setOnClickListener {
            colorActivity.changeTextGreen()
        }
        binding.btnSecond.setOnClickListener {
            colorActivity.changeTextBlue()
        }
        binding.btnThird.setOnClickListener {
            colorActivity.changeTextYellow()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ColorFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ColorFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun changeColorBlue() {
       binding.fragment.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.blue))
        binding.tvColor.setText("Blue")
    }

    override fun changeColorYellow() {
        binding.fragment.setBackgroundColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.yellow
            )
        )
        binding.tvColor.setText("Yellow")
    }

    override fun changeColorGreen() {
        binding.fragment.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.green))
        binding.tvColor.setText("Green")
    }
}