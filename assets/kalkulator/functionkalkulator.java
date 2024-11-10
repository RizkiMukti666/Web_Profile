function Solve(val) {
   var v = document.getElementById('calcu');
   v.value += val;
}

function Result() {
    var num1 = document.getElementById('calcu').value;
    try {
        var num2 = eval(num1.replace('x', '*'));
        document.getElementById('calcu').value = num2;
    } catch (error) {
        document.getElementById('calcu').value = 'Error';
        console.error('Error evaluating expression:', error);
    }
}

function Clear() {
   var inp = document.getElementById('calcu');
   inp.value = '';
}

function Back() {
   var ev = document.getElementById('calcu');
   ev.value = ev.value.slice(0, -1);
}

document.addEventListener('keydown', function (event) {
   const key = event.key;
   const validKeys = '0123456789+-*/.%';
   if (validKeys.includes(key)) {
      Solve(key === '*' ? 'x' : key);
   } else if (key === 'Enter') {
      Result();
   } else if (key === 'Backspace') {
      Back();
   } else if (key.toLowerCase() === 'c') {
      Clear();
   }
});