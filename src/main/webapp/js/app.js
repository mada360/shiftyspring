const React = require('react');
const ReactDOM = require('react-dom')
const client = require('./client');

const numbers = [1, 2, 3, 4, 5];
const listItems = numbers.map((number) =>
    <li>{number}</li>
);

class App extends React.Component {

	static render() {
		return (
            <h1>React</h1>
        )
	}
}

ReactDOM.render(
    <ul>{listItems}</ul>,
	document.getElementById('react')
);
