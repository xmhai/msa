import React, { Component } from 'react';

class UserInfo extends Component {

  constructor(props) {
    super(props);
    this.state = {
      name: "",
      email: "",
      id: ""
    };
    this.props.keycloak.loadUserInfo().then(userInfo => {
        this.setState({name: userInfo.name, email: userInfo.email, id: userInfo.sub})
    });
  }

  render() {
    return (
      <div className="UserInfo">
        <p>Name: {this.state.name}</p>
        <p>Email: {this.state.email}</p>
        <p>ID: {this.state.id}</p>
        <p>Access Token: {this.props.keycloak.token}</p>
        <p>ID Token: {this.props.keycloak.idToken}</p>
      </div>
    );
  }
}
export default UserInfo;
