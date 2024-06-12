import { createContext, useState } from "react";
import PropTypes from "prop-types";

const AuthContext = createContext();

const AuthProvider = ({ children }) => {
  const [user, setUser] = useState(null);
  const [userDetails, setUserDetails] = useState(null);

  const login = (userData) => {
    setUser(userData);
  };

  const logout = () => {
    setUser(null);
  };

  const userDetailsFn = (userDetails) => {
    setUserDetails(userDetails)
  }

  return (
    <AuthContext.Provider value={{ user, userDetails, userDetailsFn,  login, logout }}>
      {children}
    </AuthContext.Provider>
  );
};

AuthProvider.propTypes = {
  children: PropTypes.node.isRequired,
};

export { AuthContext, AuthProvider };
