// IMPORTS
import { TabManager } from "./tabManager.js";


// GLOBALS
const tabManager = new TabManager("control");
tabManager.start();

let serverWasDown = false;
let reloadDone = false;

const sliders = [document.getElementById("joint0_slider"), document.getElementById("joint1_slider"),
    document.getElementById("joint2_slider"), document.getElementById("joint3_slider"),
    document.getElementById("joint4_slider"), document.getElementById("joint5_slider")
];


// FUNCTIONS

async function postSliderValues() {

    // Während der Server nicht erreichbar ist,
    // keine Steuerungsdaten senden
    if (serverWasDown) {
        return;
    }

    const data = {
        "shoulder_pan.pos": parseFloat(sliders[0].value),
        "shoulder_lift.pos": parseFloat(sliders[1].value),
        "elbow_flex.pos": parseFloat(sliders[2].value),
        "wrist_flex.pos": parseFloat(sliders[3].value),
        "wrist_roll.pos": parseFloat(sliders[4].value),
        "gripper.pos": parseFloat(sliders[5].value)
    };

    try {
        const response = await fetch("/api/control", {
            method: "POST",
            body: JSON.stringify({
                "time": Date.now() / 1000,
                "deviceId": "control_publisher",
                "data": data
            }),
            headers: {
                "Content-type": "application/json; charset=UTF-8"
            }
        });

        if (!response.ok) {
            throw new Error("POST fehlgeschlagen");
        }

    } catch (err) {
        console.error("Server nicht erreichbar:", err);
        serverWasDown = true;
        reloadDone = false;
    }
}


function resetSliders() {

    sliders.forEach(slider => {
        const min = parseFloat(slider.min);
        const max = parseFloat(slider.max);

        slider.value = (min + max) / 2;
    });
}


async function checkServerRestart() {

    try {
        const response = await fetch("/api/health", {
            cache: "no-store"
        });

        if (response.ok && serverWasDown && !reloadDone) {

            serverWasDown = false;
            reloadDone = true;

            resetSliders();

            console.log("Server wieder erreichbar - Slider zurückgesetzt");
        }

    } catch (err) {
        serverWasDown = true;
        reloadDone = false;
    }
}


// EVENTS

sliders.forEach(slider => {
    slider.addEventListener("input", postSliderValues);
});

setInterval(postSliderValues, 100);
setInterval(checkServerRestart, 1000);