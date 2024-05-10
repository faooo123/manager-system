package com.ebay.manager.dto.request;

import com.ebay.manager.entity.UserAccessInfo;
import com.ebay.manager.exception.ApplicationErrorCode;
import com.ebay.manager.exception.ApplicationException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserRequest {
    private String userId;
    private List<String> endpoints;

    public void valid(){
        if(userId == null) throw new ApplicationException(ApplicationErrorCode.BAD_PARAMS);
    }

    public UserAccessInfo convertToUserAccessInfo(){
        return new UserAccessInfo(userId, endpoints);
    }
}
