
'use strict'
let fs = require('fs');

fs.readFile('input.txt', 'utf8', (err, lines) => {
	if (err) return;
	let previous, sum = 0;
	const numbers = lines.split("");
	numbers.forEach(x => {
		let num = parseInt(x);
		if (previous == num) {
			sum += num
		}
		previous = num;
	});
	if (numbers[0] == numbers[numbers.length-1]) sum += parseInt(numbers[0])
	console.log(sum)
});