package com.murat.socialmediagraphql.services;

import com.murat.socialmediagraphql.models.User;

public interface UserService {
    User getUserByUsername(String username);
}
