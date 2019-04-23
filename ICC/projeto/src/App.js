import React, { Component } from 'react';
import './App.css';

class App extends Component {
  constructor() {
    super();
    this.state = {
      nome: "",
      presente: "",
      entendimento: "",
      comentario: ""
    };
    this.onChange = (evento) => {
      const state = Object.assign({}, this.state);
      const campo = evento.target.name;
      state[campo] = evento.target.value;
      this.setState(state);
    };
    this.onSubmit = (evento) => {
      evento.preventDefault();
      //validação
      console.log(this.state);
    };
  }
  render() {
    return (
      <div className="App">
        <head>
          <title>Avaliação da aula</title>
        </head>

        <body>
          <div id="area">
            <form id="formulario" autoComplete="off">
              <fieldset>
                <legend>Avaliação da aula</legend>
                <label>Nome:</label><input name="nome" className="campo_nome" value={this.state.nome} onChange={this.onChange} type="text" /><br />
                <label>Matricula:</label><input name="matricula" value={this.state.matricula} onChange={this.onChange} className="campo_matricula" type="texto" /><br />
                <label>Data da aula:</label><input name="data" type="date" className="campo_data" type="date" /><br />
                <label>Você estava presente? </label>
                Sim<input name="presente" type="radio" value="sim" onChange={this.onChange} checked={this.state.presente === "sim"} className="campo_presente_sim"/>
                Não<input name="presente" type="radio" value="nao" onChange={this.onChange} checked={this.state.presente === "nao"} className="campo_presente_nao" />
                <br />
                <label>Entendimento da aula:</label>
                1<input name="entendimento" type="radio" value="1" onChange={this.onChange} checked={this.state.entendimento === "1"} className="opcao"/>
                2<input name="entendimento" type="radio" value="2" onChange={this.onChange} checked={this.state.entendimento === "2"} className="opcao"/>
                3<input name="entendimento" type="radio" value="3" onChange={this.onChange} checked={this.state.entendimento === "3"} className="opcao"/>
                4<input name="entendimento" type="radio" value="4" onChange={this.onChange} checked={this.state.entendimento === "4"} className="opcao"/>
                5<input name="entendimento" type="radio" value="5" onChange={this.onChange} checked={this.state.entendimento === "5"} className="opcao"/>
                <br />
                1 - Não entendi nada <br />
                5 - Entendi tudo
                <br />
                <label>Deixe um comentário, alguma questão que ficou em dúvida ou algum conteúdo que não entendeu:</label><br /><textarea name="comentario" value={this.state.comentario} onChange={this.onChange} className="campo_comentario" cols="35" rows="8"></textarea><br />
                <button onClick={this.onSubmit} className="btn_submit" >Enviar</button>
              </fieldset>
            </form>
          </div>
        </body>
      </div>
    );
  }
}

export default App;