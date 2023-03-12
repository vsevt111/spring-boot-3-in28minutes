
//default import
import MyFirstComponent from './FirstComponent';
//named import
import {FifthComponent} from './FirstComponent';
import TenthComponent from './FirstComponent';
import MySecondComponent from './SecondComponent';
import ThirdComponent from './ThirdComponent';
import FourthComponent from './FourthComponent';
import LearningJavaScript from './LearningJavaScript'

export default function LearningComponent() {
    return (
      <div className="App">
        My Todo Application
        <MyFirstComponent/>
        <MySecondComponent/>
        <ThirdComponent/>
        <FourthComponent/>
        <FifthComponent/>
        <TenthComponent/>
        <LearningJavaScript/>
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