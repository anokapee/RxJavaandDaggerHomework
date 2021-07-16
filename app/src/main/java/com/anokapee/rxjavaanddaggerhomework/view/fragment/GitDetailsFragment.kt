package com.anokapee.rxjavaanddaggerhomework.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anokapee.rxjavaanddaggerhomework.databinding.FragmentGitDetailsBinding
import com.anokapee.rxjavaanddaggerhomework.model.data.GitResponseItem
import com.anokapee.rxjavaanddaggerhomework.util.Constants.Companion.PARSE_KEY

class GitDetailsFragment: Fragment() {
    companion object{
        lateinit var gitDetailsFragment: GitDetailsFragment

        fun getInstance(gitResponseItem: GitResponseItem): GitDetailsFragment{
            if (!this::gitDetailsFragment.isInitialized)
                gitDetailsFragment = GitDetailsFragment()

            return gitDetailsFragment.also {
                it.arguments = Bundle().also { bundle ->
                    bundle.putParcelable(PARSE_KEY, gitResponseItem)
                }
            }
        }
    }

    private lateinit var binding: FragmentGitDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGitDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getParcelable<GitResponseItem>(PARSE_KEY)?.let {
            binding.gitDetailsName.text = it.name
        }

    }
}