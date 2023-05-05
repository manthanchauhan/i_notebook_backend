package com.example.i_notebook_backend.user.dtos.response;

import com.example.i_notebook_backend.user.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileResponseDto {
    private String firstName;
    private String lastName;
    private String email;

    public static UserProfileResponseDto fromUser(User user){
        return new UserProfileResponseDto(user.getFirstName(), user.getLastName(), user.getEmail());
    }
}
