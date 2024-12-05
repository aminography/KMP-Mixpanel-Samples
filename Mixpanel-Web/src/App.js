import {
    Container, Button
} from 'react-bootstrap';

import React, { useState } from 'react'

const umbrellaKlib = require('@yousee/umbrellaklib').dk.yousee.kmp
const mixpanelKlib = require('@yousee/umbrellaklib').dk.yousee.kmp.mixpanel

function App() {
    umbrellaKlib.di.start()
    mixpanelKlib.di.MixpanelModule.load()

    console.log("XXXXXXXXXXXXXXXXXXX  Lib Version: " + umbrellaKlib.BuildProperties.VERSION)

    const mixpanel = mixpanelKlib.di.MIXPANEL_DELEGATE.resolve()
    mixpanel.init(umbrellaKlib.BuildProperties.MIXPANEL_API_TOKEN_TEST)

    return ContentView(mixpanel)
}

function ContentView(mixpanel) {
    const [counter, setCounter] = useState(1)

    const onTrackClicked = () => {
        mixpanel.track(
            new mixpanelKlib.event.LoginEvent(
                mixpanelKlib.event.LoginEvent.AuthProvider.Ping,
                'Web Test Event #' + counter
            )
        )
        setCounter(counter + 1)
    }

    return (
        <>
            <Container className='mainContainer'>
                <Button variant="primary" className='button' onClick={onTrackClicked}>Log Event #{counter}</Button>
            </Container>
        </>
    )
}

export default App;
