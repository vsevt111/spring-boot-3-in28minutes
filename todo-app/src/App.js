// import logo from './logo.svg';
import './App.css';

// import LearningComponent from './components/learning-examples/LearningComponent';
import TodoApp from './components/todo/TodoApp'

import 'bootstrap/dist/css/bootstrap.min.css'

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
      <TodoApp/>
      {/* <PlayingWithProbs property1='value1' property2='value2'/> */}
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

//{property1: 'value1', property2: 'value2'}
// function PlayingWithProbs(properties){
//   console.log(properties);
//   console.log(properties.property1)
//   console.log(properties.property2)
// }

//alternative to get probs value is use deconstructing
//modern way to get value from probs
// function PlayingWithProbs({property1,property2}){
//   console.log(property1)
//   console.log(property2)
// }


export default App;
