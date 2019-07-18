package com.nmh.speaktotext.mvvmtestabank.ui.repo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.nmh.speaktotext.mvvmtestabank.base.BaseViewHolder;
import com.nmh.speaktotext.mvvmtestabank.databinding.RepoItemBinding;
import com.nmh.speaktotext.mvvmtestabank.model.Repository;

import java.util.List;

public class RepoListAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<Repository> repositoryList;

    public void addItems(List<Repository> repository) {
        repositoryList.addAll(repository);
        notifyDataSetChanged();
    }

    public void clearItems() {
        repositoryList.clear();
    }

    public RepoListAdapter(List<Repository> repoResponseList) {
        this.repositoryList = repoResponseList;

    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        RepoItemBinding repoItemBinding = RepoItemBinding
                .inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
        return new RepoItemViewHolder(repoItemBinding);
    }


    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }


    @Override
    public int getItemCount() {
        if (repositoryList != null && repositoryList.size() > 0) {
            return repositoryList.size();
        } else {
            return 1;
        }
    }

    public class RepoItemViewHolder extends BaseViewHolder {

        private RepoItemBinding mBinding;

        private RepoItemViewModel repoItemViewModel;


        public RepoItemViewHolder(RepoItemBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            if (repositoryList.size() == 0) {
                return;
            }
            final Repository repository = repositoryList.get(position);
            repoItemViewModel = new RepoItemViewModel(repository);
            mBinding.setViewModel(repoItemViewModel);

            mBinding.executePendingBindings();
        }
    }
}
