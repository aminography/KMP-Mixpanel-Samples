import {
    Container, Button
} from 'react-bootstrap';

import React, { useState } from 'react'

const diKlib = require('@yousee/umbrellaklib').dk.yousee.kmp.di
const mixpanelKlib = require('@yousee/umbrellaklib').dk.yousee.kmp.mixpanel

function App() {
    diKlib.start()
    mixpanelKlib.di.MixpanelModule.load()

    const mixpanel = mixpanelKlib.di.MIXPANEL_DELEGATE.resolve()

    return ContentView(mixpanel)
}

function ContentView(mixpanel) {
    const [counter, setCounter] = useState(1)

    const onTrackClicked = () => {
        mixpanel.track('Web Test Event #' + counter)
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
