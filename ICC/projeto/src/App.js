import React, { Component } from 'react';
import './App.css';

var data = new Date();
var dataAtual = data.getDate() + '/' + (data.getMonth()+1) + '/' + data.getFullYear();

class App extends Component {
  render() {
    return (
      <div className="App">
       <h1>{dataAtual}</h1>
       <div>
         <h2>Avalie a aula</h2>
        <button name="button1" value="1" onclick="alert(this.value)">1</button> 
        <button name="button2">2</button>
        <button name="button3">3</button>
        <button name="button4">4</button>
        <button name="button5">5</button>

       </div>
      </div>
    );
  }
}

export default App;
