import Vue from 'vue'

export const userKey = '__knowledge_user'
export const baseApiUrl = 'https://34.203.91.20:4001'
// export const baseApiUrl = 'http://localhost:4001'

export function showError(e) {
    if(e && e.response && e.response.data) {
        Vue.toasted.global.defaultError({ msg : e.response.data })
    } else if(typeof e === 'string') {
        Vue.toasted.global.defaultError({ msg : e })
    } else {
        Vue.toasted.global.defaultError()
    } 
}

export default { baseApiUrl, showError, userKey }
