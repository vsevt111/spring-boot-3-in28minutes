// import logo from './logo.svg';
import './App.css';

import LearningComponent from './components/learning-examples/LearningComponent';



/*
curly braces to import not export default (name import)
use parenthesis to return complex JSX(JavaScript XML)
use PascalCase naming for Component
use lower case for html element
each JSX can have one-top-level element(one parent element)
Babel convert JSX to JS for backward compatabilty
*/

function App() {
  return (
    <div className="App">
      My Todo Application
      <LearningComponent/>
      {/* <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header> */}
    </div>
  );
}

export default App;
