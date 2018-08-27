package com.juanbrz.componentexample.component;

import com.juanbrz.componentexample.exception.NotAuthorizedException;
import com.juanbrz.componentexample.model.User;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Component;

@Component
public class DatabaseComponentImpl implements DatabaseComponent {

  /**
   * We need two maps, one for look user by userId
   * and other for look for user by userName
   */
  private Map<String, User> userIdToUserMap;
  private Map<String, User> userNameToUserMap;

  public DatabaseComponentImpl(){
    /**
     * We need concurrentHashMap to avoid concurrency issues
     */
    userIdToUserMap = new ConcurrentHashMap<>();
    userIdToUserMap = new ConcurrentHashMap<>();
  }

  @Override
  public User getUser(String username, String password) {
    User user = userNameToUserMap.get(username);
    if(user == null || !user.getPassword().equals(password)){
      throw new NotAuthorizedException("Error in the login");
    }

    return user;
  }

  @Override
  public User save(User user) {
    String userId = UUID.randomUUID().toString();
    user.setId(userId);

    saveInMemory(user);
    return user;
  }

  /**
   * Save the user in both maps
   * @param user
   */
  private void saveInMemory(User user){
    userIdToUserMap.put(user.getId(), user);
    userNameToUserMap.put(user.getUserName(), user);
  }
}
