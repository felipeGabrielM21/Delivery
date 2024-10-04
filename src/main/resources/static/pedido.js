document.getElementById('finalizar-pedido').addEventListener('click', function() {
    const feijoada = parseInt(document.getElementById('feijoada').value) || 0;
    const frango = parseInt(document.getElementById('frango').value) || 0;
    const carne = parseInt(document.getElementById('carne').value) || 0;
    const parmegiana = parseInt(document.getElementById('parmegiana').value) || 0;
    const total = parseFloat(document.getElementById('total-price').textContent) || 0;

    // Log dos valores para depuração
    console.log("Feijoada:", feijoada);
    console.log("Frango:", frango);
    console.log("Carne:", carne);
    console.log("Parmegiana:", parmegiana);
    console.log("Total:", total);

    // Verifica se há algum item com quantidade maior que 0
    if (feijoada > 0 || frango > 0 || carne > 0 || parmegiana > 0) {
        fetch("http://localhost:8080/pedido", {  // Use http:// se o servidor não suportar https
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
            },
            method: "POST",
            body: JSON.stringify({
                feijoada: feijoada,
                frango: frango,
                carne: carne,
                parmegiana: parmegiana,
                total: total
            })
        })
        .then(response => response.json())
        .then(data => {
            if (data) {
                alert("Pedido realizado com sucesso!");
                console.log(data);
            } else {
                alert("Erro ao efetuar o pedido.");
            }
        })
        .catch(error => {
            console.error("Erro ao enviar o pedido:", error);
            alert("Erro ao efetuar o pedido.");
        });
    } else {
        alert("Adicione ao menos um item ao pedido.");
    }
});

function updateQuantity(item, change) {
    const input = document.getElementById(item);
    const priceSpan = document.getElementById(item + '-price');
    let currentValue = parseInt(input.value);
    const price = parseFloat(priceSpan.textContent);

    if (currentValue + change >= 0) {
        input.value = currentValue + change;
        updateTotal();
    }
}

function updateTotal() {
    const items = ['feijoada', 'frango', 'carne', 'parmegiana'];
    let total = 0;

    items.forEach(item => {
        const quantity = parseInt(document.getElementById(item).value);
        const price = parseFloat(document.getElementById(item + '-price').textContent);
        total += quantity * price;
    });

    document.getElementById('total-price').textContent = total.toFixed(2);
}
