var next1Btn = document.querySelector('.next1'),
    prev1Btn = document.querySelector('.prev1'),
    carousel = document.querySelector('.carousel'),
    list1 = document.querySelector('.list1'),
    item1 = document.querySelectorAll('.item1'),
    runningTime = document.querySelector('.carousel .timeRunning')

let timeRunning = 3000
let timeAutoNext = 7000

next1Btn.onclick = function () {
    showSlider('next1')
}

prev1Btn.onclick = function () {
    showSlider('prev1')
}

let runTimeOut

let runNextAuto = setTimeout(() => {
    next1Btn.click()
}, timeAutoNext)


function resetTimeAnimation() {
    runningTime.style.animation = 'none'
    runningTime.offsetHeight /* trigger reflow */
    runningTime.style.animation = null
    runningTime.style.animation = 'runningTime 7s linear 1 forwards'
}


function showSlider(type) {
    let sliderItemsDom = list1.querySelectorAll('.carousel .list1 .item1')
    if (type === 'next1') {
        list1.appendChild(sliderItemsDom[0])
        carousel.classList.add('next1')
    } else {
        list1.prepend(sliderItemsDom[sliderItemsDom.length - 1])
        carousel.classList.add('prev1')
    }

    clearTimeout(runTimeOut)

    runTimeOut = setTimeout(() => {
        carousel.classList.remove('next1')
        carousel.classList.remove('prev1')
    }, timeRunning)


    clearTimeout(runNextAuto)
    runNextAuto = setTimeout(() => {
        next1Btn.click()
    }, timeAutoNext)

    resetTimeAnimation() // Reset the running time animation
}

// Start the initial animation 
resetTimeAnimation()