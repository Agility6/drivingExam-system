package com.t.jk.common.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;

/**
 * ClassName: TokenMatcher
 * Description:
 *
 * @Author agility6
 * @Create 2024/2/21 10:38
 * @Version: 1.0
 */
public class TokenMatcher implements CredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo) {
        return false;
    }
}
