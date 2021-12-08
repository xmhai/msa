import React, { Component } from 'react';
import axios from 'axios';
import Keycloak from 'keycloak-js';

import UserInfo from './UserInfo';
import Logout from './Logout';

class Secured extends Component {
  constructor(props) {
    super(props);
    this.state = { keycloak: null, authenticated: false };
  }

  componentDidMount() {
    const keycloak = Keycloak('/keycloak.json');
    keycloak.init({onLoad: 'login-required'}).then(authenticated => {
      this.setState({ keycloak: keycloak, authenticated: authenticated })
    })
  }

  handleOnClickService1 = () => {
    let config = {
        headers: {
            'Authorization': `Bearer ${this.state.keycloak.token}`,
        }
    }

    axios.get(`http://localhost:8083/service1/data`, config)
      .then(res => {
        console.log(res);
        alert(res.statusText);
      })
  }

  handleOnClickService2 = () => {
    let config = {
        headers: {
            'Authorization': `Bearer ${this.state.keycloak.token}`,
        }
    }

    axios.get(`http://localhost:8083/service2/data`, config)
      .then(res => {
        console.log(res);
        alert(res.statusText);
      })
  }

  render() {
    if(this.state.keycloak) {
      if(this.state.authenticated) {
       return (
        <div>
          <p><button onClick={this.handleOnClickService1} type="button">Service1</button></p>
          <p><button onClick={this.handleOnClickService2} type="button">Service2</button></p>
          <UserInfo keycloak={this.state.keycloak} />
          <Logout keycloak={this.state.keycloak} />
        </div>
      ); } else {
          return (<div>Unable to authenticate!</div>)
        }
    }
    return (
      <div>Initializing Keycloak...</div>
    );
  }
}
export default Secured;

