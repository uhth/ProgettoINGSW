var tabItems = document.querySelectorAll('.tab-item');
var tabContentItems = document.querySelectorAll('.tab-content-item');
tabItems.forEach(item => { item.addEventListener('click', selectItem) });

console.log(tabItems);
console.log(tabContentItems);

// contenuto tab
function selectItem(e) {
    // rimuovi altri bordi
    removeBorder();
    removeShow();
    // aggiungi il bordo rosso al tab
    this.classList.add('tab-border');
    // Aggiungi contenuto dal DOM
    var tabContentItem = document.querySelector(`#${this.id}-content`);
    // aggiungi classe show
    tabContentItem.classList.add('show');

}

function removeBorder() {
    tabItems.forEach(item => item.classList.remove('tab-border'));
}

function removeShow() {
    tabContentItems.forEach(item => item.classList.remove('show'));
}
