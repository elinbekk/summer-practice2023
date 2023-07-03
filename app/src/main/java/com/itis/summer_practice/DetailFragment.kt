package com.itis.summerpractice2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.itis.summerpractice2.databinding.FragmentDetailBinding



class DetailFragment : Fragment(R.layout.fragment_detail) {
    private var binding: FragmentDetailBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)
        val id = arguments?.getInt(ID)
        var zodiac: Zodiac? = null
        val list = ZodiacRepo.list
        list.forEach{
            if(it.id == id){
                zodiac = it
            }
        }
        val glide = Glide.with(this)
        binding?.run {
            tvZodiac.text = zodiac?.name
            tvDesc.text = zodiac?.desc
            tvHappyNumber.text = zodiac?.happyNumber.toString()

            glide.load(zodiac?.url).into(ivImage)

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object{
        private const val ID = "ID"
        fun createBundle(id: Int):Bundle{
            val bundle = Bundle()
            bundle.putInt(ID, id)
            return bundle
        }
    }

}