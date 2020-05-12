package com.example.lfg_source.main.swipe;

import androidx.lifecycle.MutableLiveData;

import com.example.lfg_source.entity.Group;

import java.util.List;

public class UserSwipeViewModel<User> extends androidx.lifecycle.ViewModel {
  private MutableLiveData<List<User>> data;
  private String token;

  public void setToken(String token) {
    this.token = token;
  }

  public void setData(List<User> data) {
    this.data.setValue(data);
  }

  public MutableLiveData<List<User>> getData() {
    if (data == null) {
      data = new MutableLiveData<>();
    }
    return data;
  }

  private Group group;

  public void setGroup(Group group) {
    this.group = group;
  }

  public void sendMessage() {
    final String url = "http://152.96.56.38:8080/Group/Suggestions/" + group.getGroupId();
    RestClientUserSwipe task = new RestClientUserSwipe(this, token);
    task.execute(url);
  }
}
