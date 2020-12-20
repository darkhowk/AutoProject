package auto.common.controller;

import java.net.URL;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.benow.transmission.TransmissionClient;
import ca.benow.transmission.model.TorrentStatus;

@Controller
@RequestMapping(value = "torrent")
public class TorrentController {
//	@Autowired
//	private ajaxService ajaxService;

	@RequestMapping(value = "add", method = { RequestMethod.POST, RequestMethod.GET })
	public String add(Model model) {
		return "torrent/add";
	}
	@RequestMapping(value = "status", method = { RequestMethod.POST, RequestMethod.GET })
	public String status(Model model) throws Exception {
		
		URL url = new URL("http://memorandum.iptime.org:9091/transmission/rpc/");
		TransmissionClient tc = new TransmissionClient(url);

		List<TorrentStatus> list = tc.getAllTorrents();
		
		for(TorrentStatus ts : list) {
			System.out.println(ts.getName());
			System.out.println(ts.getId());
			System.out.println(ts.getStatus());
			System.out.println(ts.getPercentDone());
			System.out.println("--------------------");
		}
		
		model.addAttribute("TORRENT_LIST", list);
		
		return "torrent/status";
	}

}
