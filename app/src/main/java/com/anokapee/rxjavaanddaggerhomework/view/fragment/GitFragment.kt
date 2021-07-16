package com.anokapee.rxjavaanddaggerhomework.view.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.anokapee.rxjavaanddaggerhomework.databinding.GitFragmentLayoutBinding
import com.anokapee.rxjavaanddaggerhomework.model.data.GitResponseItem
import com.anokapee.rxjavaanddaggerhomework.view.activity.MainActivity
import com.anokapee.rxjavaanddaggerhomework.view.adapter.GitAdapter
import com.anokapee.rxjavaanddaggerhomework.viewmodel.GitViewModel


class GitFragment : Fragment(), GitAdapter.GitDelegate {

    interface GitSelect{
        fun openDetailsFragment(item: GitResponseItem)
    }

    private lateinit var binding: GitFragmentLayoutBinding
    private val viewModel by activityViewModels<GitViewModel>()
    private val adapter = GitAdapter(this)
    private lateinit var gitSelect: GitSelect

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = GitFragmentLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.gitRv.adapter = adapter

        viewModel.gitData.observe(viewLifecycleOwner,{
            adapter.listGitResponseItem = it
        })
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
       gitSelect = context as MainActivity
    }

    override fun selectRepo(gitResponseItem: GitResponseItem) {
        gitSelect.openDetailsFragment(gitResponseItem)
        Log.d("TAG_X", "selected ${gitResponseItem.name}")
    }
}