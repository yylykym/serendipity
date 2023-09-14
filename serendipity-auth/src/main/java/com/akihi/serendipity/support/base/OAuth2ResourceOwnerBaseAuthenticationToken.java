package com.akihi.serendipity.support.base;

import io.micrometer.common.lang.Nullable;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.util.Assert;

import java.util.*;

public abstract class OAuth2ResourceOwnerBaseAuthenticationToken extends AbstractAuthenticationToken {

    private final AuthorizationGrantType authorizationGrantType;
    private final Set<String> scopes;

    private final Authentication clientPrincipal;

    private final Map<String, Object> additionalParameters;

    public OAuth2ResourceOwnerBaseAuthenticationToken(AuthorizationGrantType authorizationGrantType,
                                                      Authentication clientPrincipal, @Nullable Set<String> scopes,
                                                     @Nullable Map<String, Object> additionalParameters) {
        super(Collections.emptyList());
        Assert.notNull(authorizationGrantType, "authorizationGrantType cannot be null");
        Assert.notNull(clientPrincipal, "clientPrincipal cannot be null");
        this.authorizationGrantType = authorizationGrantType;
        this.clientPrincipal = clientPrincipal;
        this.scopes = Collections.unmodifiableSet(scopes != null ? new HashSet<>(scopes) : Collections.emptySet());
        this.additionalParameters = Collections.unmodifiableMap(
                additionalParameters != null ? new HashMap<>(additionalParameters) : Collections.emptyMap());
    }

    @Override
    public Object getCredentials() {
        return "";
    }

    @Override
    public Object getPrincipal() {
        return this.getPrincipal();
    }

    public AuthorizationGrantType getAuthorizationGrantType() {
        return authorizationGrantType;
    }

    public Authentication getClientPrincipal() {
        return clientPrincipal;
    }

    public Set<String> getScopes() {
        return scopes;
    }

    public Map<String, Object> getAdditionalParameters() {
        return additionalParameters;
    }
}
