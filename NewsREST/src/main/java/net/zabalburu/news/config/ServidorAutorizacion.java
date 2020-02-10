package net.zabalburu.news.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

@Configuration
@EnableAuthorizationServer
public class ServidorAutorizacion 
	extends AuthorizationServerConfigurerAdapter{

	@Autowired
    private AuthenticationManager authenticationManager;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		super.configure(clients);
		clients.inMemory()
		.withClient("cliente")
		.secret(encoder.encode("password"))
		.authorizedGrantTypes("password")
		.scopes("read","write");
		
	}
	
	@Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
	    endpoints.authenticationManager(authenticationManager);
    }
	
}
