// Función para inicializar un carrusel
function initCarousel(carouselSelector, listSelector, itemSelector, nextButtonSelector, prevButtonSelector, timeRunningSelector) {
    var nextBtn = document.querySelector(nextButtonSelector),
        prevBtn = document.querySelector(prevButtonSelector),
        carousel = document.querySelector(carouselSelector),
        list = document.querySelector(listSelector),
        items = document.querySelectorAll(itemSelector),
        runningTime = document.querySelector(timeRunningSelector);

    let timeRunning = 3000;
    let timeAutoNext = 7000;

    nextBtn.onclick = function () {
        showSlider('next');
    }

    prevBtn.onclick = function () {
        showSlider('prev');
    }

    let runTimeOut;

    let runNextAuto = setTimeout(() => {
        nextBtn.click();
    }, timeAutoNext);

    function resetTimeAnimation() {
        runningTime.style.animation = 'none';
        runningTime.offsetHeight; /* trigger reflow */
        runningTime.style.animation = null;
        runningTime.style.animation = 'runningTime 7s linear 1 forwards';
    }

    function showSlider(type) {
        let sliderItemsDom = list.querySelectorAll(itemSelector);
        if (type === 'next') {
            list.appendChild(sliderItemsDom[0]);
            carousel.classList.add('next');
        } else {
            list.prepend(sliderItemsDom[sliderItemsDom.length - 1]);
            carousel.classList.add('prev');
        }

        clearTimeout(runTimeOut);

        runTimeOut = setTimeout(() => {
            carousel.classList.remove('prev');
            carousel.classList.remove('next');
        }, timeRunning);

        clearTimeout(runNextAuto);
        runNextAuto = setTimeout(() => {
            nextBtn.click();
        }, timeAutoNext);

        resetTimeAnimation(); // Reset the running time animation
    }

    // Start the initial animation 
    resetTimeAnimation();
}

// Inicializa ambos carruseles
initCarousel('.carousel1', '.list1', '.item1', '.next1', '.prev1', '.timeRunning1');
initCarousel('.carousel2', '.list2', '.item2', '.next2', '.prev2', '.timeRunning2');
