
'use strict'
let fs = require('fs');

fs.readFile('input.txt', 'utf8', (err, lines) => {
	if (err) return;
	let previous, sum1 = 0, sum2 = 0;
	const step = lines.length/2;
	const numbers = lines.split("");
	numbers.forEach((x, index, arr) => {
		let num = parseInt(x);
		if (previous == num) {
			sum1 += num;
		}
		previous = num;
		if (parseInt(arr[(index + step) % arr.length]) == num) {
			sum2 += num;
		}
	});
	if (numbers[0] == numbers[numbers.length-1]) sum1 += parseInt(numbers[0])
	console.log(sum1, sum2);
});