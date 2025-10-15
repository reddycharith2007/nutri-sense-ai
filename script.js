function logSymptoms() {
    const symptoms = document.getElementById('symptoms').value.split(',');
    fetch('/api/log-symptoms', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ symptoms })
    })
    .then(res => res.json())
    .then(data => document.getElementById('response').innerText = data.message)
    .catch(err => document.getElementById('response').innerText = 'Error');
}

function getSymptoms() {
    fetch('/api/get-symptoms')
    .then(res => res.json())
    .then(data => {
        document.getElementById('allSymptoms').innerText = JSON.stringify(data, null, 2);
    });
}
