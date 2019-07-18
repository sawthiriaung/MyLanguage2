package com.nmh.speaktotext.mvvmtestabank.ui.repo;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.nmh.speaktotext.mvvmtestabank.BR;
import com.nmh.speaktotext.mvvmtestabank.R;
import com.nmh.speaktotext.mvvmtestabank.base.BaseActivity;
import com.nmh.speaktotext.mvvmtestabank.databinding.ActivityRepolistBinding;
import com.nmh.speaktotext.mvvmtestabank.utils.ViewModelFactory;

import javax.inject.Inject;

public class RepoListActivity extends BaseActivity<ActivityRepolistBinding,RepoListViewModel> {

    @Inject
    RepoListAdapter repoListAdapter;
    @Inject
    LinearLayoutManager mLayoutManager;
    ActivityRepolistBinding repolistLayoutBinding;
    @Inject
    ViewModelFactory factory;
    private RepoListViewModel repoListViewModel;
    public static Intent newIntent(Context context) {
        return new Intent(context, RepoListActivity.class);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_repolist;
    }

    @Override
    public RepoListViewModel getViewModel() {
        repoListViewModel = ViewModelProviders.of(this,factory).get(RepoListViewModel.class);
        return repoListViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        repolistLayoutBinding = getViewDataBinding();
        setUp();
        subscribeToLiveData();
    }

    private void setUp() {
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        repolistLayoutBinding.repoItem.setLayoutManager(mLayoutManager);
        repolistLayoutBinding.repoItem.setItemAnimator(new DefaultItemAnimator());
        repolistLayoutBinding.repoItem.setAdapter(repoListAdapter);
    }

    private void subscribeToLiveData() {
        Toast.makeText(this,"hello",
                Toast.LENGTH_LONG).show();
        repoListViewModel.getRepoListLiveData()
                .observe(this, repos -> repoListViewModel.addRepoItemsToList(repos));
    }

}
