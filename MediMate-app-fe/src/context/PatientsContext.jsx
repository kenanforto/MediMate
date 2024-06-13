import { createContext, useReducer } from "react";
import PropTypes from "prop-types";

export const PatientsContext = createContext();

export const patientsReducer = (state, action) => {
  switch (action.type) {
    case "SET_PATIENTS":
      return {
        patients: action.payload,
      };
    // case "ADD_PATIENT":
    //   return {
    //     patients: [...state.patients, action.payload],
    //   };
    // case "REMOVE_PATIENT":
    //   return {
    //     patients: state.patients.filter(
    //       (patient) => patient.id !== action.payload.id
    //     ),
    //   };
    default:
      return state;
  }
};

export const PatientsContextProvider = ({ children }) => {
  const [state, dispatch] = useReducer(patientsReducer, {
    patients: null,
  });

  return (
    <PatientsContext.Provider value={{ ...state, dispatch }}>
      {children}
    </PatientsContext.Provider>
  );
};

PatientsContextProvider.propTypes = {
  children: PropTypes.node.isRequired,
};
