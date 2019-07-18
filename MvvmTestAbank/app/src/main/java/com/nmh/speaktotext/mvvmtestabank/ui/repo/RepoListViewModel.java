package com.nmh.speaktotext.mvvmtestabank.ui.repo;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.util.Log;

import com.nmh.speaktotext.mvvmtestabank.base.BaseViewModel;
import com.nmh.speaktotext.mvvmtestabank.model.Repository;
import com.nmh.speaktotext.mvvmtestabank.model.ReturnDataRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class RepoListViewModel extends BaseViewModel {

    private final ReturnDataRepository returnDataRepository;
    private CompositeDisposable disposable;
    public final ObservableList<Repository> repoObservableArrayList = new ObservableArrayList<>();

    private final MutableLiveData<List<Repository>> repoLivedata ;
    private final MutableLiveData<Boolean> repoLoadError = new MutableLiveData<>();

    @Inject
    public RepoListViewModel(ReturnDataRepository returnDataRepository) {
        this.returnDataRepository = returnDataRepository;
        disposable = new CompositeDisposable();
        repoLivedata = new MutableLiveData<>();
        fetchRepos();
    }

    public void addRepoItemsToList(List<Repository> repos) {
        repoObservableArrayList.clear();
        repoObservableArrayList.addAll(repos);
        //repoObservableArrayList.size();
        Log.i("Array list",""+repoObservableArrayList.size());

    }

    public void fetchRepos() {
        setIsLoading(true);
        disposable.add(returnDataRepository.getRepositories().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableSingleObserver<List<Repository>>() {
                    @Override
                    public void onSuccess(List<Repository> value) {
                        repoLoadError.setValue(false);
                        repoLivedata.setValue(value);
                        setIsLoading(false);
                    }

                    @Override
                    public void onError(Throwable e) {

                        repoLoadError.setValue(true);
                        setIsLoading(false);
                    }
                }));
    }
    public MutableLiveData<List<Repository>> getRepoListLiveData() {
        return repoLivedata;
    }
    public ObservableList<Repository> getRepoObservableArrayList(){
        return repoObservableArrayList;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (disposable != null) {
            disposable.clear();
            disposable = null;
        }
    }
}
