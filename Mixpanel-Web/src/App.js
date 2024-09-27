import {
    Container, Button
} from 'react-bootstrap';

import React, { useState } from 'react'

import MixpanelLib from 'foundation-mixpanelLib';
const NS = MixpanelLib.com.aminography.kmp

function App() {
    const mixpanel = NS.mixpanel.createMixpanelDelegate('a4e433e173bfbbc0e0784fc22539b790')
    
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
