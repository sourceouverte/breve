import logo from './logo.svg';
import './App.css';
import MyURLs from './components/MyURLs/MyURLs';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        
        <MyURLs />
      </header>
    </div>
  );
}

export default App;
