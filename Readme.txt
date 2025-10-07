Authentication Flow:

User submits login request Via login form, HTTP Basic, or a JWT token.

AuthenticationManager receives the request. This is the central entry point.You usually get it auto-configured or
define it as a bean.

AuthenticationManager calls AuthenticationProvider. Delegates the work to one or more AuthenticationProviders.

Each provider checks if it can handle the request.AuthenticationProvider calls UserDetailsService.
Loads the user from the database (or memory).Verifies the password using PasswordEncoder.

If successful:
Returns an Authentication object (fully authenticated).Spring stores it in the SecurityContextHolder.

If failed:
Throws an AuthenticationException (401 Unauthorized).
------------------------------------------------------------------------------------------------------

This method is used to authenticate a user (e.g., during login). If authentication is successful, it returns a JWT token.
If not, it returns "fail".

🔄 Detailed Breakdown
🟩 Authentication authentication = authManager.authenticate(...)

authManager is an instance of AuthenticationManager (typically injected).
authenticate(...) attempts to validate the user’s credentials.
It takes a UsernamePasswordAuthenticationToken containing the username and password from the input Users object.
If the credentials are valid:
Spring Security returns a populated Authentication object (with user details, roles, etc.).
If invalid, it throws a BadCredentialsException or similar.

While generating secret key need to pass bytes as input for HMACSHA256 algorithm. So string to byte decode is required.
-------------------------------------------------------------------------------------------------------------

🔐 Client sends request with JWT token in the Authorization header

✅ Your jwtFilter is called:Extracts the token, Verifies it, Loads user details,Sets authentication in the security context
🔄 Spring Security now treats the request as authenticated

